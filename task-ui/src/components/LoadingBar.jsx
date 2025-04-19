import { useNavigation } from 'react-router-dom'

import LoadingSpinner from '@/components/LoadingSpinner'

function GlobalLoadingBar() {
  const navigation = useNavigation();
  const isLoading = navigation.state === 'loading';

  return isLoading ? (
    <>
      {/* 컴포넌트 라우터 전환시 사용되는 로딩바 */}
      <LoadingSpinner />
    </>
  ) : null;
}

export default GlobalLoadingBar;