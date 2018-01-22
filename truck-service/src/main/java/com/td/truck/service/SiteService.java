package com.td.truck.service;

import com.td.truck.dto.Statistics;

/**
 * 站点Service
 *
 * @author biezhi
 * @since 1.3.1
 */
public interface SiteService {

//    List<Comment> recentComments(int limit) ;
    /**
     * 获取后台统计数据
     */
    Statistics getStatistics();
}
