package com.team.zhuoke.masterhelper.presenter.test.interfaces;


import com.team.zhuoke.masterhelper.base.CommonPresenter;
import com.team.zhuoke.masterhelper.base.CommonView;
import com.team.zhuoke.masterhelper.model.annotation.Implement;
import com.team.zhuoke.masterhelper.model.test.MasterList;
import com.team.zhuoke.masterhelper.presenter.test.imp.MasterListPresenterImp;

import java.util.List;

@Implement(MasterListPresenterImp.class)
public interface MasterListContract {

      interface View extends CommonView {

              void MasterList(List<MasterList> masterLists);
      }
      interface Presenter extends CommonPresenter {

         void getMasterList();

      }
}
