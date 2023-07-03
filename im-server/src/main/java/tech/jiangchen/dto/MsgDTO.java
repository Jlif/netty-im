package tech.jiangchen.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MsgDTO {
    @NotNull
    private Long senderUid;
    @NotNull
    private Long recipientUid;
    @NotBlank
    private String content;
    @NotNull
    private Integer msgType;
}
