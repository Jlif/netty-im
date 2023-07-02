package tech.jiangchen.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import tech.jiangchen.dto.MsgDTO;
import tech.jiangchen.service.MessageService;
import tech.jiangchen.vo.MessageContactVO;
import tech.jiangchen.vo.MessageVO;

import java.util.List;

@RestController
public class MessageController {

    @Resource
    private MessageService messageService;

    @PostMapping(path = "/sendMsg")
    public MessageVO sendMsg(@RequestBody @Valid MsgDTO dto) {
        return messageService.sendNewMsg(dto);
    }

    @GetMapping(path = "/queryMsg")
    public List<MessageVO> queryMsg(@RequestParam Long ownerUid, @RequestParam Long otherUid) {
        return messageService.queryConversationMsg(ownerUid, otherUid);
    }

    @GetMapping(path = "/queryMsgSinceMid")
    public List<MessageVO> queryMsgSinceMid(@RequestParam Long ownerUid, @RequestParam Long otherUid, @RequestParam Long lastMid) {
        return messageService.queryNewerMsgFrom(ownerUid, otherUid, lastMid);
    }

    @GetMapping(path = "/queryContacts")
    public MessageContactVO queryContacts(@RequestParam Long ownerUid) {
        return messageService.queryContacts(ownerUid);
    }
}
