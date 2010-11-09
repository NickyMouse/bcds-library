package com.alibaba.intl.bcds.goldroom.search.job;

import java.util.Date;

import org.apache.log4j.Logger;
import org.compass.gps.CompassGps;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * search engine full build job
 *
 * @author Giraffe
 */
public class IndexBuildJob {

    private static Logger logger       = Logger.getLogger(IndexBuildJob.class);

    private CompassGps    compassGps;

    private boolean       buildOnStart = true;

    public void init() {
        if (buildOnStart) {
            fullBuild();
        }
    }

    public void setCompassGps(CompassGps compassGps) {
        this.compassGps = compassGps;
    }

    /**
     * full build data to index
     */
    public void fullBuild() {
        Date start = new Date();
        compassGps.index();
        Date end = new Date();
        logger.info("index builder full index cost time :" + (end.getTime() - start.getTime()));
    }

    public void setBuildOnStart(boolean buildOnStart) {
        this.buildOnStart = buildOnStart;
    }

    public boolean isBuildOnStart() {
        return buildOnStart;
    }
}
