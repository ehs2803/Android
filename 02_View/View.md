### 뷰

뷰(view)는 화면 안에 들어가는 각각의 요소를 말하며 일반적으로 컨트롤이나 위젯이라고 불린다. 즉 사용자 눈에 보이는 화면의 구성 요소들이 뷰이다.

### 뷰그룹

뷰를 여러 개 포함하고 있는 것. 
뷰그룹 안에서 뷰의 위치를 지정할 수 있다.
뷰그룹 안에는 뷰뿐만 아니라 뷰그룹도 넣을 수 있음.
뷰와 뷰그룹의 관계는 여러 가지 디자인 패턴 중에 컴포지트 패턴(composite pattern)을 사용해 만들어짐.

### 뷰 - 위젯, 레이아웃

안드로이드 화면을 구성하는 것들은 크게 뷰와 뷰그룹으로 나눌 수 있는데, 각각의 역할을 구분하기 위해 뷰의 종류에 따라 위젯, 레이아웃으로 구분한다.

위젯(widget)은 화면에 보이면서 일반적인 컨트롤의 역할을 하는 것.

레이아웃(layout)은 뷰그룹 중에서 내부에 뷰들을 포함하고 있으면서 그것들을 배치하는 역할을 하는 것.

### 가이드라인

가이드라인(guideline)은 여러개의 뷰를 일정한 기준 선에 정렬할 때 사용한다.