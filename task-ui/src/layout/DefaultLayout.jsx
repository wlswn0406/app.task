import { Outlet } from 'react-router-dom'

const DefaultLayout = ({ children }) => {
  return (
    <div className="default-layout-wrap">
      <Outlet />
    </div>
  )
};

export default DefaultLayout;