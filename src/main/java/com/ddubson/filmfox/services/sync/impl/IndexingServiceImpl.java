package com.ddubson.filmfox.services.sync.impl;

import com.ddubson.filmfox.services.sync.IndexingService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class IndexingServiceImpl implements IndexingService {
    @Autowired
    Logger sysLog;

    @Override
    //@Scheduled(fixedRate = 5000)
    public void sync() {
        sysLog.info("Scheduled indexing service started at " + DateTime.now().toString());
        sysLog.info("Scheduled indexing service finished at " + DateTime.now().toString());
    }
}
