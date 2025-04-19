import { lazy } from 'react'
import { createBrowserRouter } from 'react-router-dom'

import DefaultLayout from '@/layout/DefaultLayout'
import MainLayout from '@/layout/MainLayout'

const Main = lazy(() => import('@/modules/Main'));
const ErrorPage = lazy(() => import('@/modules/ErrorPage'));

const router = createBrowserRouter([
  {
    path: '/',
    element: <MainLayout />,
    errorElement: <ErrorPage />,
    children: [
      { index: true,   element: <Main />, },
      { path: 'index', element: <Main />, },
      { path: 'main',  element: <Main />, },
      { path: 'home',  element: <Main />, },
    ],
  },

  {
    path: '*',
    element: <DefaultLayout />,
    children: [
      { path: '*', element: <ErrorPage />, },
    ],
  },
]);

export default router;