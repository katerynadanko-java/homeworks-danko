"# homeworks-danko" 

Homework 01 - Написать программу, которая получает из командной строки ответы на 
2 вопроса. Ответом на первый вопрос является слово “polymorphism”, на второй - 
слово “overloaded”. Другие вводы игнорировать с соответствующим комментарием в командной строке. 
              Правильные ответы выводятся на экран. 
              Должен быть применен паттерн MVC.iwq
              
Homework 02 - Напишите игровую JAVA – программу, которая отгадывает число по принципу – «больше – 
меньше»: 
1. программа должна загадать произвольное число в диапазоне от 0 до 100.
             Функция rand. Описание:
             int rand ( [int min, int max] )
             Например, если вам нужно случайное число между 5 и 15 (включительно), 
             вызовите rand (5, 15).
             Замечание: При вызове без параметров min и max, возвращает псевдослучайное целое 
             в диапазоне от 0 до RAND_MAX.
             2. пользователю предлагается попробовать угадать число путем последовательного 
             ввода чисел из диапазона ограниченного сначала числами 0 и 100, а при дальнейших 
             попытках – с учетом ранее введенных чисел. Программа должна анализировать ввод 
             на любые ошибочные действия пользователя.
             3. На экране должно отображаться предыдущие попытки, диапазон, в котором находится 
             искомое число и результат предыдущего действия пользователя.
             4. При совпадении чисел – программа должна сообщить об этом пользователю и вывести 
             всю статистику по действиям пользователя.   
             
             Задание по тестированию. Просмотреть видео, повторить код.      
Homework 03 - Игра “Больше – меньше”
             1. Создать на бесплатном репозитории (например GitHub) свой раздел.
             2. Подключить к GitHub игровую программу (учитывая правила взаемодействия с GitHub – использовать gitIgnore и т.д.)
             3. Внести нужные исправления в игровую программу, иммитирую командную работу с Git.
             4. Методы бизнес-логики должны быть покрыты модульными тестами.
             
Homework 04 - Создание структуры для ввода данных с командной строки с помощью регулярных выражений  
              написать необходимую структуру ввода данных из командной строки и передать результат ввода в соответствующую сущность. 
              Оформить согласно JCC,  написать JavaDOC; 
              эта структура должна проверять на правильность ввод данных (сохраняя правильно введенные) и в случае полной валидности 
              всех данных – передает их в соответствующий класс в модели. 
              Создать сущность Запись в Записная книжка, которая состоит: 
              Фамилия абонента  
              Имя абонента 
              Отчество абонента 
              Сформировать из введенных данных: Фамилия + Пробел + Первая буква Имени + точка 
              Никнейм  
              Комментарий  
              Группы в которую занесен абонент (Enum с названиями групп). 
              Телефон дом 
              Телефон моб. 
              Телефон моб. 2 (может отсутствовать) 
              Е-майл 
              Скайп 
              Адрес, состоящий из: 
              - Индекс 
              - город проживания 
              - улица 
              - номер дома 
              - номер квартиры 
              Строка полного адреса сформированного из данных п.13. 
              Даты внесения записи в записную книжку 
              Даты последнего изменения записи             
Homework 05 - Использовать код программы из задания «Создание структуры для ввода данных с командной строки с помощью 
              регулярных выражений». 
              Сымитировать ситуацию, когда запись, поступающая в записную книжку, содержит поле логин,  существующий в 
              данной записной книжке.  
              Исключительная ситуация должна вернуть данные в контроллер (и, например, опубликовать их) и попросить 
              пользователя сменить логин на другой.  
              После соответствующего ввода, запись должна повторно поступить в модель.    
Homework 06 - Создать immutable object (обязательно должна присутствовать ссылка на mutable часть). Научиться писать 
              его в электронном блокноте безошибочно.                         
