package com.jazda.mapapi;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class NestedRoute {

    private Long id;
    private List<Section> sectionList;
}
