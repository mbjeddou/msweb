package com.example.shared;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data

@Getter
@Setter
public class VoitureDTO {
    private Long id;
    private String name;
    private String remorquageZone;
}
