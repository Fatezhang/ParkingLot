- Given:

Parking boy, one ParkingLot A(0/1),  car a

- When:

Parking car a

- Then

Get a ticket A/a



---

- Given

Parking boy, one ParkingLot A(1/1),ticket

- When

Pick car

- Then

get a car

---

- Given

Parking boy, 2 ParkingLot (A = 0/2 ,B=0/2), 2 car(a, b)

- When

Parking 2 cars

- Then

Get tickets A/a,A/b

---

- Given 

Parking boy, 2 ParkingLot ( A = 1/2 ,B=1/2), 2 car(a, b)

- When 

Parking  2 cars

- Then 

Get 2 tickets A/a, B/b

---

- Given

Parking boy, 2 ParkingLot (A = 0/2 ,B=0/2), 3 car(a, b, c)

- When

Parking 3 cars

- Then

Get 3 tickets.A/a,A/b,B/c

---

- Given

Parking boy, 3 ParkingLot (A = 0/1 ,B=0/1, C=0/1), 3 car(a, b, c)

- When

Parking 3 cars

- Then

Get 3 tickets.A/a,B/b,C/c

---

- Given 

Parking boy, 2 ParkingLot ( A = 2/2 ,B=1/2), 2 car(a, b)

- When 

Parking  2 cars

- Then 

Get ticket for car a(B/a) and Alert error message for car b

---

Smart ParkingBoy

---

停车在空位最多的停车场



- given

  一个聪明的泊车小弟，两个分别停了1 辆车和 2 辆车的停车场，总车位都是 3

- when

  选择空位最多的停车场

- Then

  选出空位最多的



Given
  一个聪明的停车小弟， 管理一个停车场A（0/1）； 一辆车a
When
  停a车
Then
  获得一张停车票（A-a）Given
  一个聪明的停车小弟， 管理一个停车场A（1/1）；一张停车票（A-a），
When
  取车
Then
  获得一辆车aGiven
  一个聪明的停车小弟，管理三个停车场A（2/3）B（1/3）C（2/3）；一辆车a
When
  停a车
Then
  获得一张停车票（B-a）Given
  一个聪明的停车小弟，管理三个停车场A（2/3）B（0/3）C（0/3）；两辆车a，b，
When
  依次停a车和b车
Then
  获得两张停车票（B-a）和（C-b）Given
  一个聪明的停车小弟，管理三个停车场A（3/3）B（3/3）C（3/3）；一辆车a
When
  停a车
Then
  提示停车失败

---------------------

新需求：

- 1. Parking Manager可以自己停车，也可以让小弟停车
- 2. Parking Manager停车策略同Smart Parking Boy
- 3. 停车场已满时，Parking Manager停车提示停车失败
- 4. Parking Manager管理其他小弟
- 5. Parking Manager停车策略：
- 6. 停车顺序为Graduate Parking Boy -> Smart Parking Boy -> Parking Manager
- 7. 小弟类型一样时，按加入顺序停车
- 8. Graduate Parking Boy, Smart Parking Boy, Parking Manager管理的停车场没有交集，他们各自管理不同的停车场
- 9. 车票上不包含停车小弟的信息

********************************

## Tasking:

|                         given                         |          when           |                     then                     |
| :---------------------------------------------------: | :---------------------: | :------------------------------------------: |
|   一个 ParkingManager，没有员工，一个停车场，一个车   |   ParkingManager 停车   | 停车并且拿到有相应停车场和车牌的信息的停车票 |
|   一个 ParkingManager，一个有效的停车票，一个停车场   |   ParkingManager 取车   |         取车成功并获取到相应车牌的车         |
| 一个 ParkingManager，没有员工，一个满的停车场，一个车 |   ParkingManager 停车   |         返回错误信息：No parking lot         |
|   一个 ParkingManager，一个有效的停车票，一个停车场   | ParkingManager 取车两次 |        返回错误信息：Invalide ticket         |
|   一个 ParkingManager，拥有一个 GradParkingBoy 和一个 SmartParkingBoy，分别拥有一个停车场，一个车   |  ParkingManager 停车  |  停车到  |
|      |    |     |
|      |    |     |
|      |    |     |
|      |    |     |
|      |    |     |
|      |    |     |
|      |    |     |

