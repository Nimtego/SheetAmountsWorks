package view.windows;



import controller.TegWin;
import controller.WindowController;
import view.windows.windows_colection.WindowSheetAmount;
import view.windows.windows_colection.WindowSimpleError;
import view.windows.windows_colection.WindowViewUserReg;

import java.util.HashMap;
import java.util.Map;

import static controller.TegWin.SHEET_AMOUNT;
import static controller.TegWin.SIMPLE_ERROR;
import static controller.TegWin.USER_REG;

/**
 * Created by myasnikov
 * on 01.08.2017.
 */
public class WindowViewFabric {
    public static Map<TegWin,WindowView> simpleMapView(WindowController windowController) {
        Map<TegWin, WindowView> windowViewMap = new HashMap<>();
        windowViewMap.put(USER_REG, new WindowViewUserReg(windowController));
        windowViewMap.put(SIMPLE_ERROR, new WindowSimpleError(windowController));
        windowViewMap.put(SHEET_AMOUNT, new WindowSheetAmount(windowController));
        return windowViewMap;
    }
}
