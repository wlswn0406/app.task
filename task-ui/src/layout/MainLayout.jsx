import { Outlet } from 'react-router-dom'
import { Suspense } from 'react'

import LoadingBar from '@/components/LoadingBar'
import LoadingSpinner from '@/components/LoadingSpinner'

function MainLayout({ children }) {

  return (
    <div className="main-layout-wrap">

      <LoadingBar />

      {/* 컴포넌트 로드시 사용되는 로딩바 */}
      <Suspense fallback={<LoadingSpinner />}>
        <Outlet />
      </Suspense>
    
    </div>
  );
}

export default MainLayout;