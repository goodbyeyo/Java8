package com.study.java8;

import java.util.Optional;

public class OnlineClass {

    private Integer id;

    private String title;

    private boolean closed;

    public Progress progress;

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }


    /*
    public Progress getProgress() {
        if (this.progress == null) {
            // Runtime Exception -> 클라이언트 쪽 고통이 덜함
            // Cheked Exception -> 에러처리를 강제함
            // 에러가 발생하면 -> Call Stack -> StackTrace 출력 -> Resource 사용
            // 로직을 처리할때 에러를 사용하는것은 좋은 습관이 아님

            throw new IllegalStateException();
        }
        return progress;
    }
    */

    public Optional<Progress> greProgress() {
        // Optional.ofNullable(null 일수 있는 객체)
        // return Optional.ofNullable(progress);   // 리턴타입으로 쓰는것만이 권장사항
        return Optional.empty();
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public <U> U getProgress() {
    }


    /*
    public void setProgress(Optional<Progress> progress) {
        if (progress.isPresent()) { // 이 메서드 자체가 NullPointException
            progress.ifPresent(p -> this.progress = p);
        }
    }
    */

}
