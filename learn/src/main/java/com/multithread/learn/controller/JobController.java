package com.multithread.learn.controller;

import com.multithread.learn.constants.CommConstants;
import com.multithread.learn.dto.Result;
import com.multithread.learn.pojo.ScheduleJob;
import com.multithread.learn.service.SchedulerJobService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 定时任务控制器
 */
@RequestMapping("/job/manage")
@RestController
@Slf4j
public class JobController {
    private final SchedulerJobService schedulerJobService;

    @Autowired
    public JobController(SchedulerJobService schedulerJobService) {
        this.schedulerJobService = schedulerJobService;
    }

    /**
     * 获取所有的任务
     */
    @RequestMapping("/getAllJobs")
    public Result getAllJobs() {
        return schedulerJobService.getAllScheduleJob();
    }

    /**
     * 获取正在执行的任务列表
     *
     * @return Result
     */
    @RequestMapping("/getRunJob")
    public Result getAllRunningJob() {
        return schedulerJobService.getAllRunningJob();
    }

    /**
     * 更新或者添加一个任务
     *
     * @param scheduleJob 任务
     */
    @RequestMapping("/saveOrUpdate")
    public Result addOrUpdateJob(@RequestBody ScheduleJob scheduleJob) {
        Result result = new Result(false, CommConstants.RESULT_CODE.ERROR);
        try {
            return schedulerJobService.saveOrUpdate(scheduleJob);
        } catch (Exception e) {
            log.error("[JobController] addOrUpdateJob is failure in method:addOrUpdateJob！");
            return result;
        }
    }

    /**
     * 运行一个任务
     *
     */
    @RequestMapping("/runOneJob")
    public Result runJob(@RequestBody ScheduleJob scheduleJob) {
        Result result = new Result(false, CommConstants.RESULT_CODE.ERROR);
        try {
            return schedulerJobService.runOneJob(scheduleJob.getJobName(), scheduleJob.getJobGroup());
        } catch (SchedulerException e) {
            log.error("[JobController] runOnejob is failure in method:runJob");
            result.setMessage("运行出错");
            return result;
        }
    }

    /**
     * 停止一个定时任务
     *
     */
    @RequestMapping("/pauseJob")
    public Result pauseJob(@RequestBody ScheduleJob scheduleJob) {
        Result result = new Result(false, CommConstants.RESULT_CODE.ERROR);
        try {
            return schedulerJobService.pauseJob(scheduleJob.getJobName(), scheduleJob.getJobGroup());
        } catch (SchedulerException e) {
            log.error("[JobController] pauseJob is failure in method:pauseJob");
            result.setMessage("停止任务出错");
            return result;
        }
    }

    /**
     * 删除一个定时任务
     *
     * @return Result
     */
    @RequestMapping("/deleteJob")
    public Result deleteJob(@RequestBody ScheduleJob scheduleJob) {
        Result result = new Result(true, CommConstants.RESULT_CODE.SUCCESS);
        try {
            return schedulerJobService.deleteJob(scheduleJob.getJobName(), scheduleJob.getJobGroup());
        } catch (SchedulerException e) {
            log.error("[JobController] deleteJob is failre in method: deleteJob!");
            result.setMessage("删除任务出错");
            return result;
        }
    }

    /**
     * 重启一个定时任务
     *
     */
    @RequestMapping("/resumeJob")
    public Result resumeJob(@RequestBody ScheduleJob scheduleJob) {
        Result result = new Result(false, CommConstants.RESULT_CODE.ERROR);
        try {
            return schedulerJobService.resumeJob(scheduleJob.getJobName(), scheduleJob.getJobGroup());
        } catch (SchedulerException e) {
            log.error("[JobController] resumeJob is failre in method: resumeJob!");
            result.setMessage("重启任务出错");
            return result;
        }
    }


}
