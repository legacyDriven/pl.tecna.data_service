Należy zaimplementować dwa mikroserwisy oparte o Spring Boot i Spring Cloud, 
z których jeden będzie posiadał kontroler REST/HTTP, 
natomiast drugi będzie łączyć się z pamięciową bazą danych i pobierać i zapisywać z/do niej dane.



Na żądanie użytkownika przesłane do pierwszego serwisu (zewnętrznego), kontroler powinien wywołać drugi serwis (wewnętrzny), 
pobrać z niego dane i zwrócić użytkownikowi. Serwis zewnętrzny powinien być ukryty za gateway’em pełniącym rolę proxy.

Komunikacja między dwoma serwisami powinna być zrealizowana poprzez RestTemplate z użyciem nazwy drugiego mikroserwisu, 
a nie poprzez adres IP i port (podpowiedź: adnotacja @LoadBalanced)

Oba serwisy powinny zgłaszać się w rejestrze usług, np. w Netflix Eureka.

Drugi serwis (wewnętrzny) powinien tworzyć schemat bazy danych poprzez bibliotekę FlywayDB lub Liquibase. 
Serwis powinien posiadać encję umożliwiającą przechowanie kodu źródłowego skryptu Groovy 
(wymagane atrybuty encji to przynajmniej ID, Nazwa, Opis, Kod źródłowy skryptu).

Pierwszy serwis powinien udostępniać REST API dostarczające operacje CRUD, łącznie z możliwością 
pobrania listy rekordów z uwzględnieniem stronicowania, sortowania i filtrowania danych. 
Filtrowanie powinno być możliwe po dowolnym atrybucie encji (Nazwa, Opis), 
przy czym to klient API powinien decydować, po jakich atrybutach wyszukuje dane.

Pierwszy serwis powinien udostępniać kontroler umożliwiający wywołanie skryptu o danej nazwie 
(przechowywanego w encji) z parametrami przekazanymi w żądaniu (np. POST)
i zwrócenie wyniku w odpowiedzi. Logika wywoływania skryptów powinna znajdować się w drugim serwisie (wewnętrznym).


Tak naprawdę powinny więc powstać cztery usługi: dwie właściwe oraz usługa rejestru usług i usługa gateway’a. 
Istotna jest realizacja integracji między usługami i skorzystanie z modułów Spring Cloud 
oraz poprawna implementacja metod CRUD (w szczególności listowanie z wyszukiwaniem).



Do szybkiego wygenerowania szkieletów projektów polecam https://start.spring.io/

- dla rejestru usług potrzebne są zależności: Web, Eureka Server

- dla gatewaya potrzebne są zależności: Spring Cloud Gateway, Eureka Discovery

- dla usługi nr 1 potrzebne są zależności: Web, Eureka Discovery

- dla usługi nr 2 potrzebne są zależności: Eureka Discovery, Flyway, H2

- do wywoływania skryptów Groovy można użyć klasy GroovyShell lub interfejsu ScriptEngine





Proszę wrzucić kod źródłowy rozwiązania na repozytorium (np. Github), najlepiej jako Merge/Pull Request,
aby było można komentować wprowadzane zmiany.