package com.zw.wagescale.service;

import com.zw.domain.Wagesscale;

public interface WagesscaleService {
    int addWagesscale(Wagesscale wagesscale);

    Wagesscale queryminTime();

    Wagesscale getWagesscaleByWid(String wid);

    int modifyWagesscale(Wagesscale wagesscale);

    int deleteWagesscale(String wid);

}
