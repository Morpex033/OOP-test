# OOP - test

Интерфейс IWorker:
В интерейсе описан метод Payroll который подсчитывает зарплату для классов Hour Worker и Fixed Worker за 31 день.

Абстрактный класс Worker:
Класс наследуют методы интерфейса IWorker. По принципу инкапсуляции все поля классов приватные и обращатся к ним возможно только через методы. 
Переопредлен метод Payroll для каждого класса соответсвенно.

Класс Worker List:
Данный класс представляет из себя датабазу на основе класса List хранящуюся в оперативной памяти. Реалезованы методы get(поиск по индексу), workerList(создание коллекции на основе IWorker), sortByPayroll(сортировка по зароботку), sortById(сортировка по Id).

Класс Main:
Метод main в котором создается датабаза WorkerList, выводится в консоль первые 5 работников из списка, сортируется по Id после чего снова выводится в консоль 3 работника от большего к меньшему.
Реалезованы методы для генерации случайных обьектов классов HourWorker и FixedWorker используемые классом Worker List для создания датабазы.
