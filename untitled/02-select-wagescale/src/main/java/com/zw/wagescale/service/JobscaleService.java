package com.zw.wagescale.service;

import com.zw.domain.Jobscale;

public interface JobscaleService {
    int insertJobscale(Jobscale jobscale);

    Jobscale queryJobscale();

    int deleteJobscale(String jid);
    Jobscale getJobscaleByWid(String jid);

     int updateJobscale(Jobscale jobscale);
}
