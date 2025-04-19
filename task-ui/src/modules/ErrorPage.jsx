import { useRouteError, isRouteErrorResponse } from 'react-router-dom'

function ErrorPage() {
  const error = useRouteError();

  let title = 'Page not found';
  let message = '요청하신 페이지가 존재하지 않거나 이동되었습니다.';

  if(isRouteErrorResponse(error)) {
    if(error.status === 401) {
      title = 'Unauthorized';
      message = '해당 페이지에 접근할 권한이 없습니다.';

    } else if(error.status === 500) {
      title = 'Server error';
      message = '서버에서 문제가 발생했습니다. 잠시 후 다시 시도해주세요.';
    }
  }

  return (
    <section className="common-wrap error-wrap">
      <h1 className="error-title">{title}</h1>
      <p className="error-message">{message}</p>
      <a href="/">Home</a>
    </section>
  );
}

export default ErrorPage;