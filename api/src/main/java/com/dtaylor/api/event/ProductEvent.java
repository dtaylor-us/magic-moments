package com.dtaylor.api.event;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ProductEvent {

    private Long eventId;

    private EventType eventType;


}
