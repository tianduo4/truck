package com.td.truck.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.td.truck.dto.Statistics;
import com.td.truck.model.Attach;
import com.td.truck.model.Content;
import com.td.truck.service.AttachService;
import com.td.truck.service.ContentService;
import com.td.truck.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by King on 2017/12/9.
 */
@Service
public class SiteServiceImpl implements SiteService {
//    public MapCache mapCache = new MapCache();

    @Autowired
    private ContentService contentService;

    @Autowired
    private AttachService attachService;

//    @Autowired
//    private

    /**
     * 最新收到的评论
     *
     * @param limit 评论数
     */
//    public List<Comment> recentComments(int limit) {
////        if (limit < 0 || limit > 10) {
////            limit = 10;
////        }
////        Page<Comment> commentsPage = new Comment().page(1, limit, "created desc");
////        return commentsPage.getRows();
//        return new ArrayList<>();
//    }

    /**
     * 获取后台统计数据
     */
    @Override
    public Statistics getStatistics() {

//        Statistics statistics = mapCache.get(Types.C_STATISTICS);
//        if (null != statistics) {
//            return statistics;
//        }

        Statistics statistics = new Statistics();

        EntityWrapper<Content> contentQuery = new EntityWrapper<Content>();
        long articles = contentService.selectCount(contentQuery);
//        long pages      = new Contents().where("type", Types.PAGE).and("status", Types.PUBLISH).count();
//        long comments   = new Comments().count();
        EntityWrapper<Attach> attachQuery = new EntityWrapper<Attach>();
        long attachs    = attachService.selectCount(attachQuery);
//        long tags       = new Metas().where("type", Types.TAG).count();
//        long categories = new Metas().where("type", Types.CATEGORY).count();

        long pages = 0L;
        long comments = 0L;
        long tags = 0L;
        long categories = 0L;

        statistics.setArticles(articles);
        statistics.setPages(pages);
        statistics.setComments(comments);
        statistics.setAttachs(attachs);
        statistics.setTags(tags);
        statistics.setCategories(categories);

//        mapCache.set(Types.C_STATISTICS, statistics);
        return statistics;
    }
}
