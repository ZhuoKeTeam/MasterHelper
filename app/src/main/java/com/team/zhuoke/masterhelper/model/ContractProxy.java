package com.team.zhuoke.masterhelper.model;


import com.team.zhuoke.masterhelper.base.BaseModel;
import com.team.zhuoke.masterhelper.base.BasePresenter;
import com.team.zhuoke.masterhelper.base.BaseView;
import com.team.zhuoke.masterhelper.model.annotation.Implement;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.os.Build.VERSION_CODES.M;

public class ContractProxy {
    private static final ContractProxy m_instance = new ContractProxy();

    public static ContractProxy getInstance() {
        return m_instance;
    }

    private ContractProxy() {
        m_objects = new HashMap<>();
    }

    private Map<Class, Object> m_objects;

    /**
     * 进行初始化
     *
     * @param clss
     */
    public void init(Class... clss) {
        for (Class cls : clss) {
            if (cls.isAnnotationPresent(Implement.class)) {
//                list.add(cls);
                for (Annotation ann : cls.getDeclaredAnnotations()) {
                    if (ann instanceof Implement) {
                        try {
                            m_objects.put(cls, ((Implement) ann).value().newInstance());
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /**
     * 绑定Persenter
     *
     * @param clzz
     * @param var1
     * @param <T>
     * @return
     */
    public <T> T bindPresenter(Class clzz, BaseView var1) {
        if (!m_objects.containsKey(clzz)) {
            init(clzz);
        }
        BasePresenter presenter = ((BasePresenter) m_objects.get(clzz));
        if (var1 != presenter.getView()) {
            if (presenter.getView() != null) {
                presenter.detachView();
            }
            presenter.attachView(var1);
        }
        return (T) presenter;
    }

    // 初始化model add map
    public <M> M bindModel(Class clzz,BasePresenter presenter) {
        if (!m_objects.containsKey(clzz)) {
            init(clzz);
        }
        BaseModel model = ((BaseModel) m_objects.get(clzz));
        if (model != presenter.getModel()) {
            if (presenter.getModel() != null) {
                presenter.detachModel();
            }
            presenter.attachModel(model);
        }
        return (M) model;
    }

    // 解除绑定 移除map
    public void unbindPresenter(Class clzz, BaseView var1) {
        if (m_objects.containsKey(clzz)) {
            BasePresenter presenter = ((BasePresenter) m_objects.get(clzz));
            if (var1 != presenter.getView()) {
                if (presenter.getView() != null)
                    presenter.detachView();
                m_objects.remove(clzz);
            }

        }
    }

    // 解除绑定 移除map
    public void unbindModel(Class clzz, BasePresenter presenter) {
        if (m_objects.containsKey(clzz)) {
            BaseModel model = ((BaseModel) m_objects.get(clzz));
            if (model != presenter.getModel()) {
                if (presenter.getModel() != null)
                    presenter.detachModel();
                m_objects.remove(clzz);
            }

        }
    }
}