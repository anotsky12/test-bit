для зaпуска проекта необходимо
1.Прописать login и pass в файле application.property для postgres
2.После успешного соединения с базой данных необходимо выполнить sql querry из одноимённого файла проекта для заполнения данными необходимых таблиц
3.Проверить работоспособность api по url: http://localhost:8080/api/
доступные end-point's:
 1.	/cities – перечень городов с указанием количества домов
 2.	/streets – перечень улиц с указанием количества домов с запросом по городу  /streets?city_id={city_id}
 3.	/houses – перечень домов с указанием полного адреса и количества квартир с запросом по конкретной улице / городу  /houses?city_id={city_id} и /houses? street_id={street_id} 
                  
