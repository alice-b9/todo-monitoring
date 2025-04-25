## 📌 프로젝트 개요
Spring Boot 기반 간단한 Todo 관리와 관리자 대시보드 기능을 제공하는 애플리케이션에 OpenTelemetry를 연동하여 Grafana로 모니터링하는 시스템을 구축하는 프로젝트입니다. Docker 및 Kubernetes 환경에서 Helm Chart로 배포됩니다.

## 🛠 기술 스택
- Java 17
- Spring Boot 3.4.4
- Spring Data JPA
- DB: H2 (개발용) or MySQL
- OpenTelemetry SDK, Collector
- Grafana
- Docker
- Kubernetes
- Helm

## 🚀 빠른 시작
```bash
# 1. 네임스페이스 생성
kubectl apply -f manifests/namespace.yaml

# 2. 애플리케이션 빌드 및 배포
docker build -t todo-app:latest ./app
helm dependency update helm/todo-app
helm install todo-app ./helm/todo-app -n todo
```

## 📁 주요 디렉토리
- `app/` - Todo 애플리케이션 소스
- `helm/` - Helm 차트 정의
- `manifests/` - 공통 K8s 리소스 정의

## 📊 Grafana 대시보드
- JVM Memory
- HTTP 요청 응답 시간
- Tempo 연동하여 Trace 시각화

## 🧩 확장 아이디어
- Prometheus 메트릭 수집
- Prometheus Alertmanager와 연동한 알림 시스템
- 클러스터 자동 스케일링 설정
- Keycloak 인증 연동

## 🙋‍ 만든 사람
- GitHub: alice.b9
- Email: su9581@gmail.com