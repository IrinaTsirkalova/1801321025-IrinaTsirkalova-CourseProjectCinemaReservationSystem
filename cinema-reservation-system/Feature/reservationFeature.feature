Feature: Правене на резервация за филм
  
  Scenario: Правене на резервация за филм не по-късно от 60 минути преди прожекцията и за свободно място в залата  
    Given Потребителя отваря екрана за резервация на филм на "06-02-2021 17:28"
    And Избира името на филма "Железният човек"
    When Избира датата и часа на прожекцията "06-02-2021 18:30"
    And Избира броя на билетите "2"
    And Избира местата "14", "15"
    And Натиска върху бутона за резервация.
    Then Вижда съобщение "Успешно направихте резервация".
    
    Scenario: Правене на резервация за филм не по-късно от 60 минути преди прожекцията и за заето място в залата  
    Given Потребителя отваря екрана за резервация на филм на "06-02-2021 17:28"
    And Избира името на филма "Железният човек"
    When Избира датата и часа на прожекцията "06-02-2021 18:30"
    And Избира броя на билетите "2"
    And Избира местата "11", "12"
    And Натиска върху бутона за резервация.
    Then Вижда съобщение "Избраните места са заети".
    
    Scenario: Правене на резервация за филм по-късно от 60 минути преди прожекцията и за свобосно място в залата  
    Given Потребителя отваря екрана за резервация на филм на "06-02-2021 18:00"
    And Избира името на филма "Железният човек"
    When Избира датата и часа на прожекцията "06-02-2021 18:30"
    And Избира броя на билетите "2"
    And Избира местата "14", "15"
    And Натиска върху бутона за резервация.
    Then Вижда съобщение "Неуспешна резервация. Не можете да направите резервация по-късно от 60 минути преди филма".

    Scenario: Правене на резервация за филм по-късно от 60 минути преди прожекцията и за заето място в залата  
    Given Потребителя отваря екрана за резервация на филм на "06-02-2021 18:00"
    And  Избира името на филма "Железният човек"
    When Избира датата и часа на прожекцията "06-02-2021 18:30"
    And Избира броя на билетите "2"
    And Избира местата "11", "12"
    And Натиска върху бутона за резервация.
    Then Вижда съобщение "Неуспешна резервация. Не можете да направите резервация по-късно от 60 минути преди филма. Избраните места са заети".
    
    Scenario: Правене на резервация за филм без избрани места 
    Given Потребителя отваря екрана за резервация на филм на "06-02-2021 17:28"
    And  Избира името на филма "Железният човек"
    When Избира датата и часа на прожекцията "06-02-2021 18:30"
    And Избира броя на билетите "2"
    And Избира местата "", ""
    And Натиска върху бутона за резервация.
    Then Вижда съобщение "Неуспешна резервация. Моля изберете място в залата".
    
    Scenario: Правене на резервация за филм без да е избран броя на билетите
    Given Потребителя отваря екрана за резервация на филм на "06-02-2021 17:28"
    And  Избира името на филма "Железният човек"
    When Избира датата и часа на прожекцията "06-02-2021 18:30"
    And Избира броя на билетите "0"
    And Избира местата "14", "15"
    And Натиска върху бутона за резервация.
    Then Вижда съобщение "Неуспешна резервация. Моля изберете броя на билетите".
    
    Scenario: Правене на резервация за филм без да е избрана дата и час на прожекция
    Given Потребителя отваря екрана за резервация на филм на "06-02-2021 17:28"
    And  Избира името на филма "Железният човек"
    When Избира датата и часа на прожекцията ""
    And Избира броя на билетите "2"
    And Избира местата "14", "15"
    And Натиска върху бутона за резервация.
    Then Вижда съобщение "Неуспешна резервация. Моля изберете датата и час на прожекция".
    
    Scenario: Правене на резервация за филм без да е избрано името на филма
    Given Потребителя отваря екрана за резервация на филм на "06-02-2021 17:28"
    And  Избира името на филма ""
    When Избира датата и часа на прожекцията ""
    And Избира броя на билетите "2"
    And Избира местата "14", "15"
    And Натиска върху бутона за резервация.
    Then Вижда съобщение "Неуспешна резервация. Моля изберете филм".
    