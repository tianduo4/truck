package com.td.truck.admin.common;

import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 * Created by King on 2017/12/16.
 */
public class PageVo<T>{
        private int pageNum = 1;
        private int limit = 10;
        private int prevPage = 1;
        private int nextPage = 1;
        private int totalPages = 1;
        private long totalRows = 0L;
        private List<T> list;
        private boolean isFirstPage = false;
        private boolean isLastPage = false;
        private boolean hasPrevPage = false;
        private boolean hasNextPage = false;
        private int navPages = 8;
        private int[] navPageNums;


         public PageVo(Page<T> page) {
            this.init(page.getTotal(), page.getCurrent(), page.getSize());
             this.list=page.getRecords();
        }

        private void init(long total, int pageNum, int limit) {
            this.totalRows = total;
            this.limit = limit;
            this.totalPages = (int)((this.totalRows - 1L) / (long)this.limit + 1L);
            if(pageNum < 1) {
                this.pageNum = 1;
            } else if(pageNum > this.totalPages) {
                this.pageNum = this.totalPages;
            } else {
                this.pageNum = pageNum;
            }

            this.calcNavigatePageNumbers();
            this.judgePageBoudary();
        }

        private void calcNavigatePageNumbers() {
            int startNum;
            if(this.totalPages <= this.navPages) {
                this.navPageNums = new int[this.totalPages];

                for(startNum = 0; startNum < this.totalPages; ++startNum) {
                    this.navPageNums[startNum] = startNum + 1;
                }
            } else {
                this.navPageNums = new int[this.navPages];
                startNum = this.pageNum - this.navPages / 2;
                int endNum = this.pageNum + this.navPages / 2;
                int i;
                if(startNum < 1) {
                    startNum = 1;

                    for(i = 0; i < this.navPages; ++i) {
                        this.navPageNums[i] = startNum++;
                    }
                } else if(endNum > this.totalPages) {
                    endNum = this.totalPages;

                    for(i = this.navPages - 1; i >= 0; --i) {
                        this.navPageNums[i] = endNum--;
                    }
                } else {
                    for(i = 0; i < this.navPages; ++i) {
                        this.navPageNums[i] = startNum++;
                    }
                }
            }

        }

        private void judgePageBoudary() {
            this.isFirstPage = this.pageNum == 1;
            this.isLastPage = this.pageNum == this.totalPages && this.pageNum != 1;
            this.hasPrevPage = this.pageNum != 1;
            this.hasNextPage = this.pageNum != this.totalPages;
            if(this.hasNextPage) {
                this.nextPage = this.pageNum + 1;
            }

            if(this.hasPrevPage) {
                this.prevPage = this.pageNum - 1;
            }

        }

        public int getPageNum() {
            return this.pageNum;
        }

        public int getLimit() {
            return this.limit;
        }

        public int getPrevPage() {
            return this.prevPage;
        }

        public int getNextPage() {
            return this.nextPage;
        }

        public int getTotalPages() {
            return this.totalPages;
        }

        public long getTotalRows() {
            return this.totalRows;
        }

        public List<T> getList() {
            return this.list;
        }

        public boolean isFirstPage() {
            return this.isFirstPage;
        }

        public boolean isLastPage() {
            return this.isLastPage;
        }

        public boolean isHasPrevPage() {
            return this.hasPrevPage;
        }

        public boolean isHasNextPage() {
            return this.hasNextPage;
        }

        public int getNavPages() {
            return this.navPages;
        }

        public int[] getNavPageNums() {
            return this.navPageNums;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public void setPrevPage(int prevPage) {
            this.prevPage = prevPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public void setTotalRows(long totalRows) {
            this.totalRows = totalRows;
        }

        public void setList(List<T> list) {
            this.list = list;
        }

        public void setFirstPage(boolean isFirstPage) {
            this.isFirstPage = isFirstPage;
        }

        public void setLastPage(boolean isLastPage) {
            this.isLastPage = isLastPage;
        }

        public void setHasPrevPage(boolean hasPrevPage) {
            this.hasPrevPage = hasPrevPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public void setNavPages(int navPages) {
            this.navPages = navPages;
        }

        public void setNavPageNums(int[] navPageNums) {
            this.navPageNums = navPageNums;
        }
}
