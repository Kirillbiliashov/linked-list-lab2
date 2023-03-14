# Linked List
Даний застосунок представляє собою реалізацію зв'язаного списку. Зв'язаний список - 
структура даних, яка зберігає кожен елемент у спеціальному контейнеру (або вузлі), що 
містить посилання на наступний елемент, або також на попередній елемент (у випадку двозв'язного списку). 
Застосунок дозволяє читати, записувати, видаляти елементи, а також клонувати список, змінювати порядок його елементів та
додавати до нього елементи іншої колекції.

## Номер залікової - 1303, варіант - 1303 % 4 = 3
Початкова реалізація списку - список на базі вбудованих масивів/списків.
Друга реалізація списку - двобічно зв'язаний список.

## Збірка проекту та отримання виконуваного файлу
Якщо у вас не встановлена утиліта mvn, то тут можна знайти інформацію по її встановленню: https://www.baeldung.com/install-maven-on-windows-linux-mac
Для збірки проекту (та запуску тестів) потрібно виконати команду ``mvn package`` у кореневій папці. Дана команда 
згенерує виконуваний .jar файл, який буде лежати у дииректорії ``/target``. Для виконання .jar файлу треба ввести
команду ``java -jar <ім'я-файлу>.jar`` у директорії, в якій знаходиться цей файл.

## Посилання на комміт
Комміт, на якому впали тести: https://github.com/Kirillbiliashov/linked-list-lab2/commit/a4cefcabda8caa7490dcc370c0b8f61f403b097b

Лог з error, згенерований CI: https://github.com/Kirillbiliashov/linked-list-lab2/actions/runs/4397981172/jobs/7701486325

# Висновок
Незважаючи на немалу трату часу задля написання тестів, воно себе виправдовує. Так, наприклад, я написав реалізацію 
двозв'язного списку, закоммітив її, потим написав для списку тести і помітив, що певні методи в мене працюють некоректно. 
Тобто, якщо я не написав би тести, то в мене так і лежала б неправильна реалізація списку, і хтось інший міг би її використовувати, 
вважаючи, що реалізація коректна. Отже, тести треба розглядати як досить гарну самоперевірку, яка може боротися з так званою проблемою 'замиленого глазу'
