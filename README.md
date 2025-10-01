# Todo-MVVM-Java

### 프로젝트 설명  
이 프로젝트는 **MVVM 패턴 실습**에 초점을 맞춘 간단한 Java TodoList 앱입니다.  
Room 데이터베이스를 활용하여 로컬에 데이터를 저장하며, View ↔ ViewModel ↔ Model 간의 역할을 분리하는 것을 학습하는 목적을 가지고 있습니다.  

---

## 🛠️ 기술 스택  

- **언어 (Languages)**: Java, XML  
- **개발 환경**: Android Studio  
- **아키텍처 (Architecture)**: MVVM (Model-View-ViewModel)  
- **데이터베이스 (Database)**: Room  

---

## 🔄 앱 구조 및 흐름  

앱은 **Room DB → Repository → ViewModel → View** 흐름을 기반으로 동작합니다.  

1. **Room DB (Model 계층)**  
   - TodoEntity: DB에 저장될 데이터 구조 정의  
   - TodoDao: 데이터 접근을 위한 인터페이스 (삽입, 삭제, 조회 등)  

2. **Repository**  
   - DAO를 통해 실제 데이터베이스에 접근  
   - 데이터 소스를 추상화하여 ViewModel이 DB 세부 구현을 알 필요 없도록 함  

3. **ViewModel**  
   - Repository로부터 데이터를 받아 LiveData로 관리  
   - View에서 발생하는 사용자 입력(추가, 삭제 요청)을 받아 Repository에 전달  
   - UI 관련 로직을 관리하며 View와 Model을 연결  

4. **View (Activity & XML)**  
   - 사용자 입력 처리 (예: Todo 추가 버튼 클릭)  
   - ViewModel의 LiveData를 관찰(Observe)하여 UI 자동 업데이트  

---

### 📌 데이터 흐름 예시  

- 사용자가 **Todo 입력 후 추가 버튼 클릭**  
  → View가 ViewModel의 `insertTodo()` 호출  
  → ViewModel은 Repository를 통해 Room DB에 삽입 요청  
  → Room DB 변경 감지 → Repository → ViewModel의 LiveData 업데이트  
  → View는 LiveData를 구독하고 있으므로 UI 자동 반영  


---

## 📱 주요 기능  
- Todo 추가  
- Todo 삭제  
- Room DB에 데이터 영구 저장  
- LiveData를 통한 실시간 UI 반영

---

  <br> <br> <br>
## 실행 화면 (Screenshots & GIFs)
<img src="screenshot/recording.gif" width="250"/>
   

