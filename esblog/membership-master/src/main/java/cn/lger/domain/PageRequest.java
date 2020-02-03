package cn.lger.domain;

import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;

public class PageRequest extends AbstractPageRequest {
    private static final long serialVersionUID = -4541509938956089562L;
    private Sort sort;

    public PageRequest(int page, int size, Sort sort) {
        super(page, size);
    }

    public PageRequest(Integer currentPage, int i) {
        super(currentPage, i);
    }

    public static PageRequest of(int page, int size) {
        return of(page, size, Sort.unsorted());
    }

    public static PageRequest of(int page, int size, Sort sort) {
        return new PageRequest(page, size, sort);
    }

    public static PageRequest of(int page, int size, Sort.Direction direction, String... properties) {
        return of(page, size, Sort.by(direction, properties));
    }

    @Override
    public Sort getSort() {
        return this.sort;
    }

    @Override
    public Pageable next() {
        return new PageRequest(this.getPageNumber() + 1, this.getPageSize(), this.getSort());
    }

    @Override
    public PageRequest previous() {
        return this.getPageNumber() == 0 ? this : new PageRequest(this.getPageNumber() - 1, this.getPageSize(), this.getSort());
    }

    @Override
    public Pageable first() {
        return new PageRequest(0, this.getPageSize(), this.getSort());
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof org.springframework.data.domain.PageRequest)) {
            return false;
        } else {
            org.springframework.data.domain.PageRequest that = (org.springframework.data.domain.PageRequest)obj;
            return super.equals(that) && this.sort.equals(that.getSort());
        }
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + this.sort.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Page request [number: %d, size %d, sort: %s]", this.getPageNumber(), this.getPageSize(), this.sort);
    }
}
