package com.example.generalframeworkmvp.contract;

import com.example.generalframeworkmvp.base.BaseView;
import com.example.generalframeworkmvp.bean.BaseObjectBean;
import com.example.generalframeworkmvp.bean.LoginBean;

import io.reactivex.Flowable;

public interface MainContract {
    interface Modle {
        Flowable<BaseObjectBean<LoginBean>> login(String username, String password);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(BaseObjectBean<LoginBean> bean);
    }

    interface Presenter {
        /**
         * 登陆
         */
        void login(String username, String password);
    }
}
