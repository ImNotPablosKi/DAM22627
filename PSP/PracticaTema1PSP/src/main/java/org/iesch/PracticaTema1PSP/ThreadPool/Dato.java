package org.iesch.PracticaTema1PSP.ThreadPool;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Dato {

    private Integer mes;
    private Item itemMax;
    private Item itemMin;

}
