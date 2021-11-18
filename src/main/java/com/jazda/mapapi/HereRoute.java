package com.jazda.mapapi;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class HereRoute {

    private List<Route> routes;
    private Long id;
}
