package view;

import view.windows.WindowView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myasnikov
 * on 04.08.2017.
 */
public class StructWindow {
    private StructWindow parent;
    private WindowView data;
    private List<StructWindow> nodes;

    public StructWindow(WindowView data) {
        this.data = data;
        parent = null;
        nodes = new ArrayList<>();
    }

    public boolean add(WindowView data) {
        StructWindow structWindow = new StructWindow(data);
        structWindow.parent = this;
        return nodes.add(structWindow);
    }

    public StructWindow getElement(WindowView date) {
        for (StructWindow structWindow : nodes) {
            if (structWindow.data.equals(date))
                return structWindow;
        }
        return null;
    }

    public StructWindow getParent() {
        return parent;
    }

    public StructWindow getActivity() {
        if (!nodes.isEmpty()) {
            return nodes.get(0);
        }
        return this;
    }

    public WindowView getData() {
        return data;
    }

    public void deleteAndDispose() {
        if (nodes != null) {
            for (int i = 0; i < nodes.size(); i++) {
                nodes.get(i).deleteAndDispose();
            }
        }
        data.setVisible(false);
        data.dispose();
        nodes.clear();
        parent.deleteAndDispose();
    }

    public List<StructWindow> getNodes() {
        return nodes;
    }

    public void shiftStack() {
        nodes.remove(0).parent = null;
    }

    public void delete() {
        parent.nodes.remove(this);
        parent = null;
        if (nodes != null) {
            for (StructWindow st : nodes) {
                st.parent = null;
            }
        }
    }
}
