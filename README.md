## 📌 프로젝트 개요
Spring Boot 기반 간단한 Todo List API와 관리자 대시보드 기능을 제공하는 애플리케이션에 OpenTelemetry를 연동하여 Prometheus와 Grafana로 모니터링하는 시스템을 구축하는 프로젝트입니다. Docker 및 Kubernetes 환경에서 Helm Chart로 배포됩니다.

## 🛠 기술 스택
- Java 17
- Spring Boot 3.4.4
- Spring Data JPA
- DB: H2 (개발용) or MySQL
- OpenTelemetry SDK
- Prometheus
- Grafana
- Docker
- Kubernetes
- Helm

## 🚀 빠른 시작
```bash
# 1. 네임스페이스 생성
kubectl apply -f manifests/namespace.yaml

# 2. Prometheus 배포
helm install prometheus prometheus-community/prometheus \
  -n monitoring -f k8s/prometheus-values.yaml

# 3. Grafana 배포
helm install grafana grafana/grafana \
  -n monitoring -f k8s/grafana-values.yaml

# 4. Spring Boot 앱 빌드 및 배포
cd app
./mvnw clean package -DskipTests
docker build -t spring-otel-app .
kubectl apply -f helm/spring-boot/
```

## 📁 주요 디렉토리
- `app/` - Spring Boot 애플리케이션 소스
- `helm/` - Helm 차트 정의
- `k8s/` - OpenTelemetry, Prometheus 및 Grafana 설정 파일
- `manifests/` - 공통 K8s 리소스 정의

## 📊 Grafana 대시보드
- JVM Memory
- HTTP 요청 응답 시간
- @WithSpan 기반 Trace

## 🧩 확장 아이디어
- Jaeger 또는 Tempo 연동하여 Trace 시각화
- Prometheus Alertmanager와 연동한 알림 시스템
- 클러스터 자동 스케일링 설정

## 🙋‍ 만든 사람
- GitHub: alice.b9
- Email: su9581@gmail.com



## TODO
- 사용자 기반 Todo 등록, 수정, 삭제, 완료 표시
- 완료/미완료 상태별 필터링 API
- 관리자용 전체 통계 API (총 Todo 수, 사용자 수, 완료율 등)
- Swagger UI (/swagger-ui.html)
- Basic 인증 (user / password)
- 기본 통합 테스트
- Helm 배포 설정 (values.yaml)
- Grafana Dashboard에 메트릭 연동
- Prometheus Exporter 추가
- MySQL 연동
- Todo 상태 변화 로그 수집 (OpenTelemetry)