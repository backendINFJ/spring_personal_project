<h2>[2024] 스파르타 내일배움 스프링 입문주차 일정관리 앱 만들기 프로젝트 🖥️</h2>

+

<h4> 스프링 숙련주차 일정관리 - 댓글 Mapping + 댓글 CRUD + JWT + 회원가입 로그인 기능구현<br><br><br>


📌Use Case Diagram <br>
<img width="383" alt="스크린샷 2024-05-17 오후 12 38 25" src="https://github.com/backendINFJ/spring_personal_project/assets/163832566/b0ecdf89-2d86-46c5-9292-a19fa44cbc33">
<br><br><br>

----
## API 명세서

#### RequestMapping ("/api/schedules")

```http
  Post
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**: 일정 생성 |

#### 

```http
  GET /{schedulesId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `schedulesId`      | `Long` | **Required**: 선택한  일정 조회 |

```http
  GET 
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| -----------      | ----- | **Required**: 전체  일정 조회 |

```http
  Put /{schedulesId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `schedulesId`      | `Long` | **Required**: 선택한  일정 수정 |

```http
  Delete /{schedulesId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `schedulesId`      | `Long` | **Required**: 선택한  일정 삭제 |


📌erd diagram <br>
<img width="906" alt="image" src="https://github.com/backendINFJ/spring_personal_project/assets/163832566/f8ba1d9c-b21f-4390-b350-4d394cc58f3c">


