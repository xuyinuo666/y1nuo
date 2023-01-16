package com.order.mq.provider;

import com.aop.annotation.Idempotent;
import com.order.mq.MessageBuildUtil;
import com.order.mq.channel.SaveOrderChannel;


import org.springframework.messaging.Message;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.ArrayList;

@EnableBinding(value = SaveOrderChannel.class)
public class SaveOrderProvider {
    @Resource
    @Output(SaveOrderChannel.SAVE_ORDER_OUT)
    private MessageChannel channel;
    @Idempotent
    public void save() {
        channel.send(MessageBuildUtil.delayMessage("123",10000000L));
    }

    public static void main(String[] args) {
        ArrayList<String> qtimeTriggers = new ArrayList<>();
        qtimeTriggers.add("3#1670475600#5760");
        qtimeTriggers.add("4#1670475600#6000");
        ArrayList<String> seqStageIdEqpGrpIds = new ArrayList<>();
        seqStageIdEqpGrpIds.add("1#stage1#eqp1");
        seqStageIdEqpGrpIds.add("2#stage2#eqp2");
        seqStageIdEqpGrpIds.add("3#stage3#eqp3");
        seqStageIdEqpGrpIds.add("4#stage4#eqp4");
        seqStageIdEqpGrpIds.add("5#stage5#eqp5");
        seqStageIdEqpGrpIds.add("6#stage6#eqp6");
        seqStageIdEqpGrpIds.add("7#stage7#eqp7");
        ArrayList<String> stageIdEqpGrpIdCts = new ArrayList<>();
        stageIdEqpGrpIdCts.add("stage1#eqp1#100");
        stageIdEqpGrpIdCts.add("stage2#eqp2#100");

        stageIdEqpGrpIdCts.add("stage3#eqp3#1000");
        stageIdEqpGrpIdCts.add("stage4#eqp4#10000");
        stageIdEqpGrpIdCts.add("stage5#eqp5#100");
        stageIdEqpGrpIdCts.add("stage6#eqp6#100");
        stageIdEqpGrpIdCts.add("stage7#eqp7#100");
        int currentSeqUq = 1;

        double res = 0.00;
        for (String qtimeTrigger : qtimeTriggers) {
            Long triggerTimeSecondLong = Long.parseLong(qtimeTrigger.split("#")[1]);
            Long delayTimeMinuteLong = Long.parseLong(qtimeTrigger.split("#")[2]);
            Long triggerTimeMinuteLong = triggerTimeSecondLong / 60;
            Long limitQtimeErrorMinuteLong = delayTimeMinuteLong + triggerTimeMinuteLong;
            Long nowMinuteLong = 1673576036000L / (1000 * 60);
            Long remainingQtime = limitQtimeErrorMinuteLong - nowMinuteLong;

            Long remainingCycTime = 0L;
            Integer stopSeqUq = Integer.parseInt(qtimeTrigger.split("#")[0]);

            for (String seqUqStageIdEqpGrpId : seqStageIdEqpGrpIds) {
                Integer seqUq = Integer.parseInt(seqUqStageIdEqpGrpId.split("#")[0]);
                String stageId = seqUqStageIdEqpGrpId.split("#")[1];
                String eqpGrpId = seqUqStageIdEqpGrpId.split("#")[2];
                if (stopSeqUq >= seqUq && seqUq >= currentSeqUq) {
                    for (String stageIdEqpGrpIdCycTime : stageIdEqpGrpIdCts) {
                        String stageId2 = stageIdEqpGrpIdCycTime.split("#")[0];
                        String eqpGrpId2 = stageIdEqpGrpIdCycTime.split("#")[1];
                        Long cycTime = Long.parseLong(stageIdEqpGrpIdCycTime.split("#")[2]);
                        if (stageId.equals(stageId2) && eqpGrpId.equals(eqpGrpId2)) {
                            remainingCycTime += cycTime;
                        }
                    }
                }
            }
            if (remainingCycTime>0){
                double qtimeValue = (double)remainingQtime / (double)remainingCycTime;
                qtimeValue = (double) Math.round(qtimeValue * 100) / 100;
                if (qtimeValue < res){
                    res = qtimeValue;
                }
            }
        }
        System.out.println(res);

        System.out.println(qtimeTriggers);
        System.out.println(seqStageIdEqpGrpIds);
        System.out.println(stageIdEqpGrpIdCts);
    }
}
