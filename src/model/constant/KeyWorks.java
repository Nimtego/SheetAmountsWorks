package model.constant;

/**
 * Created by myasnikov
 * on 14.08.2017.
 */
public enum KeyWorks {
    NAME_DISTRICT("Имя участка"),
    TRENCH_TYPE("Тип траншеи"),
    LINE_LONG("Длина участка"),
    NUMBER_OF_CROSSING("Количество пересечений"),
    TRENCH_HEIGHT("Глубина траншеи"),
    TRENCH_WIDTH("Ширина траншеи"),
    QUANTITY_BRANCHES("Количество веток"),
    LONG_CROSSING("Длинна пересечений"),
    PIPE_STOCK("Запас трубы"),
    QUANTITY_SUPPORT("Количество опор"),
    HEIGHT_SUPPORT("Высота опор"),
    PIPE_TYPE("Тип трубы"),
    SYNTHETIC_BOOL("Синтетический материал"),
    PLATES_BOOL("Плиты"),
    CRUSHED_STONE_BOOL("Гравий"),
    ALARM_TAPE_BOOL("Сигнальная лента"),
    BOARD_BOOL("Шиты");

    private String value;
    public String getValue() {
        return value;
    }

    public static String getClassName() {
        return KeyWorks.class.getName();
    }
    KeyWorks(String s) {
        value = s;
    }
}
