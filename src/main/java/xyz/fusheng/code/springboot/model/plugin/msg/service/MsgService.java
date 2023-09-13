package xyz.fusheng.code.springboot.model.plugin.msg.service;

import org.springframework.stereotype.Service;
import xyz.fusheng.code.springboot.model.plugin.msg.mapper.MsgChannelMapper;
import xyz.fusheng.code.springboot.model.plugin.msg.mapper.MsgRuleMapper;
import xyz.fusheng.code.springboot.model.plugin.msg.mapper.MsgSendRecordMapper;
import xyz.fusheng.code.springboot.model.plugin.msg.mapper.MsgTemplateMapper;

import javax.annotation.Resource;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc MsgService
 * @date 2023-09-12 11:44 AM:32
 */

@Service
public class MsgService {

    @Resource
    private MsgChannelMapper msgChannelMapper;

    @Resource
    private MsgTemplateMapper msgTemplateMapper;

    @Resource
    private MsgRuleMapper msgRuleMapper;

    @Resource
    private MsgSendRecordMapper msgSendRecordMapper;

}

