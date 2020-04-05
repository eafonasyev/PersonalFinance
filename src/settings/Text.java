package settings;

import java.util.HashMap;

final  public  class Text {

     private static final HashMap<String,String> data = new HashMap<>();

     public static String get (String key){
        if(data.containsKey(key))return  data.get(key);
          System.out.println("Такого ключа нет");
         return "";
     }

     public static String [] getMounth(){
         String[] months = new String[12];
         months[0] = get("JANUARY");
         months[1] = get("FEBRUARY");
         months[2] = get("MARCH");
         months[3] = get("APRIL");
         months[4] = get("MAY");
         months[5] = get("JUNE");
         months[6] = get("JULY");
         months[7] = get("AUGUST");
         months[8] = get("SEPTEMBER");
         months[9] = get("OCTOBER");
         months[10] = get("NOVEMBER");
         months[11] = get("DECEMBER");
         return months;
     }

     public static void init(){
         data.put("PROGRAM_NAME","Домашняя бухгалтерия");
         data.put("MENU_FILE","Файл");
         data.put("MENU_EDIT","Редактировани");
         data.put("MENU_VIEW","Просмотр");
         data.put("MENU_HELP","Помощь");

         data.put("JANUARY","Январь");
         data.put("FEBRUARY","Февраль");
         data.put("MARCH","Март");
         data.put("APRIL","Апрель");
         data.put("MAY","Май");
         data.put("JUNE","Июнь");
         data.put("JULY","Июль");
         data.put("AUGUST","Август");
         data.put("SEPTEMBER","");
         data.put("OCTOBER","Октябрь");
         data.put("NOVEMBER","Ноябрь");
         data.put("DECEMBER","Декабрь");


         data.put("ERROR_TITLE_EMPTY","Заголовок не может быть пустым");
         data.put("ERROR_IS_EXIST","Заголовок уже существует");
         data.put("ERROR_DATE_FORMAT","Формат даты не верный");
         data.put("ERROR_NO_BASE_CURRENCY","Не выбрана базавая валюта");
         data.put("ERROR_CODE_EMPTY","Ошибка не определена");
         data.put("ERROR_CURRENCY_EMPTY","Валюта не выбрана");
         data.put("ERROR_ARTICLE_EMPTY","Не выбрана статья");
         data.put("ERROR_ACCOUNT_EMPTY","Не выбран счет");
         data.put("ERROR_RATE_INCORRECT","Не верный rate");
         data.put("ERROR_AMOUNT_FORMAT","неверный формат числа");

         data.put("FILE_MENU_NEW","Новый");
         data.put("FILE_MENU_OPEN","Открыть");
         data.put("FILE_MENU_SAVE","Сохранить");
         data.put("FILE_MENU_EXIT","Выход");
         data.put("FILE_MENU_UPDATE_CURRINCIES","Обновить валюты");
         data.put("MENU_EDIT_ADD","Добавить");
         data.put("MENU_EDI_EDIT","Редактировать");
         data.put("MENU_EDIT_DELETE","Удалить");


         data.put("MENU_VIEW_OVERVIEW","Вид");
         data.put("MENU_VIEW_ACCOUNTS","Счета");
         data.put("MENU_VIEW_ARTICLES","Статьи");
         data.put("MENU_VIEW_TRANSACTIONS","Транзакции");
         data.put("MENU_VIEW_TRANSFERS","Переводы");
         data.put("MENU_VIEW_HELP","Помощь");
         data.put("MENU_VIEW_STATISTICS","Статистика");
         data.put("MENU_VIEW_CURRENCIES","Валюты");
         data.put("MENU_HELP_ABOUT","Помощь");

         data.put("TOOLBAR_HELP","Помощь");
         data.put("TOOLBAR_STATISTICS","Статистика");
         data.put("TOOLBAR_CURRENCIES","Валюты");
         data.put("TOOLBAR_TRANSACTIONS","Транзакции");
         data.put("TOOLBAR_ACCOUNTS","Счета");
         data.put("TOOLBAR_ARTICLES","Статьи");
         data.put("TOOLBAR_OVERVIEW","Вид");

         data.put("ADD","Добавить");
         data.put("EDIT","Редактировать");
         data.put("DELETE","Удалить");
         data.put("CANCEL","Отмена");

         data.put("YES","Да");
         data.put("NO","Нет");
         data.put("OPEN_BUTTON_TEXT","Открыть");
         data.put("SAVE_BUTTON_TEXT","Сохранить");
         data.put("CANCEL_BUTTON_TEXT","Отменить");
         data.put("NAME_LABEL_TEXT","Имя файла:");
         data.put("TYPE_lABEL_TEXT","Тип файла:");
         data.put("LABEL_TITLE","Счета");
         data.put("LABEL_CURRENCIES","Вылюты");
         data.put("LABEL_START_AMOUNT","Стартовая сумма");
         data.put("LABEL_DATE","Дата");
         data.put("LABEL_ARTICLES","Статьи");
         data.put("LABEL_ACCOUNTS","Счета");
         data.put("LABEL_AMOUNT","Сумма");
         data.put("LABEL_NOTE","Комментарий");
         data.put("LABEL_ACCOUNTS_FROM","Откуда");
         data.put("LABEL_ACCOUNTS_TO","Куда");
         data.put("LABEL_AMOUNT_FROM","Ушло");
         data.put("LABEL_AMOUNT_TO","Пришло");

         data.put("LABEL_CODE","Код");
         data.put("LABEL_ON","Включена");
         data.put("LABEL_BASE","Базовая");
         data.put("LABEL_RATE","Индекс");
         data.put("ERROR","Ошибка");
         data.put("DIALOG_ABOUT","О проограмме");
         data.put("ABOUT","<bode>"
                 +"<h1>Добашняя бухгалтерия</h1>"
                 +"<p><img src=file:image/pigs.png></p>"
                 +"</body>");
         data.put("BALANCE_CURRENCIES",  "Баланс по всем валютам:   ");
         data.put("BALANCE_CURRENCIES_B","Итоговая сумма по валютам:");

         data.put("DATE","Дата");
         data.put("ACCOUNTS","Счета");
         data.put("ARTICLES","Статьи");
         data.put("AMOUNT","Сумма");
         data.put("NOTICE","Примечания");
         data.put("LAST_TRANSACTIONS","Последнии транзакции");
         data.put("TRANSACTIONS","Транзакции");
         data.put("FROM_ACCOUNT","С счета");
         data.put("TO_ACCOUNT","На счет");
         data.put("FROM_AMOUNT","С суммы");
         data.put("TO_AMOUNT","На сумму");
         data.put("TRANSFER","Переводы");
         data.put("CURRENCY","Валюты");
         data.put("TITLE_CURRENCY","Валюты");
         data.put("CODE","Код валюты");
         data.put("RATE","индех валюты");
         data.put("ON","Включена");
         data.put("BASE","Базовая");
         data.put("CHART_INCOME","Доходы по статьям");
         data.put("CHART_EXP","Расходы по статьям");
         data.put("STATISTICS","Статистика");
         data.put("ERROR_UPDATE_CURRENCIES","Ошибка при обновлении валют");
         data.put("EXIT_FILE_CONFIRM","Подтвердите что действительно хотите выйте");
         data.put("CONFIRMATION_ACTION","Подтверждение действия");
         data.put("FILE_SAVE","FILE_SAVE");
         data.put("ACCOUNT","Счета");
         data.put("PROGRAMM","Програмные файлы");
         data.put("DELETE_OPTION","Желаете ли Вы удалить строку");
         data.put("TOOLBAR_TRANSFER","Переводы");
         data.put("LABEL_NOTE","Примечания");
         data.put("NO_DATA_FOUND","Данные не найдены");

     }
}
