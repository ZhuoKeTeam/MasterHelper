//package com.team.zhuoke.masterhelper.presenter.test.interfaces;
//
//import android.content.Context;
//
//import com.team.zhuoke.masterhelper.base.BaseModel;
//import com.team.zhuoke.masterhelper.base.BasePresenter;
//import com.team.zhuoke.masterhelper.base.BaseView;
//import com.team.zhuoke.masterhelper.base.CommonPresenter;
//import com.team.zhuoke.masterhelper.base.CommonView;
//import com.team.zhuoke.masterhelper.model.annotation.Implement;
//import com.team.zhuoke.masterhelper.model.test.MasterList;
//import com.team.zhuoke.masterhelper.model.test.MasterListModel;
//import com.team.zhuoke.masterhelper.presenter.test.imp.MasterListPresenterImp;
//
//import java.util.List;
//
//import rx.Observable;
//
///**
// *  作者：gaoyin
// *  电话：18810474975
// *  邮箱：18810474975@163.com
// *  版本号：1.0
// *  类描述：   定义  业务逻辑中 Model ,Presenter,View 所需的接口
// *  备注消息：
// *  修改时间：2016/12/5 下午2:00
// **/
//
//public interface MasterListContract {
//
//    /**'
//     *  view
//     */
//    interface View extends CommonView {
//
//              void MasterList(List<MasterList> masterLists);
//      }
//
//    /**
//     *  model
//     *   Implement  指定实现类, 通过注解进行实例化
//     */
//    @Implement(MasterListModel.class)
//       interface  Model extends BaseModel{
//           Observable<List<MasterList>> MasterList(Context context);
//
//       }
//    /**
//     *  presenter
//     *      Implement  指定实现类, 通过注解进行实例化
//     */
//     @Implement(MasterListPresenterImp.class)
//     interface  Presenter extends CommonPresenter {
//
//         void getMasterList();
//    }
//
//}
