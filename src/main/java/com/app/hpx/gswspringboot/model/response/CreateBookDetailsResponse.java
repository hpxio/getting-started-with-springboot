package com.app.hpx.gswspringboot.model.response;

import com.app.hpx.gswspringboot.model.BookDetailsModel;

public class CreateBookDetailsResponse extends BaseResponse {
    private BookDetailsModel bookDetailsModel;

    public BookDetailsModel getBookDetailsModel() {
        return bookDetailsModel;
    }

    public void setBookDetailsModel(BookDetailsModel bookDetailsModel) {
        this.bookDetailsModel = bookDetailsModel;
    }
}