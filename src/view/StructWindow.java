package view;

import view.windows.WindowView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myasnikov
 * on 04.08.2017.
 */
public class StructWindow {
    private List<WindowView> windowViewList;

    public StructWindow() {
        windowViewList = new ArrayList<>();
    }
    public StructWindow(WindowView data) {
        windowViewList = new ArrayList<>();
        windowViewList.add(data);
    }

    public void add(WindowView data) {
        windowViewList.remove(data);
        windowViewList.add(0, data);
    }


    public WindowView getActivity() {
        if (windowViewList.isEmpty()) {
            return null;
        }
        return windowViewList.get(0);
    }

    public void deleteActivity() {
        windowViewList.remove(getActivity());
    }


    public void allInvisible() {
        for (WindowView windowView : windowViewList) {
            windowView.setVisible(false);
        }
    }

    public void removeActivity() {
        WindowView windowView = windowViewList.remove(0);
        windowView.setVisible(false);
        windowView.dispose();
    }

    public int getSize() {
        return windowViewList.size();
    }

    public boolean isEmpty() {
        return windowViewList.isEmpty();
    }
}
