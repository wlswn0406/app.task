import PropTypes from 'prop-types'
import { Spin } from 'antd'

function LoadingSpinner({ tip="Loading", size = "middle", children = null }) {
  return (
    <div className="loading-spinner">
      <Spin tip={tip} size={size}>
        { children }
      </Spin>
    </div>
  );
}

LoadingSpinner.propTypes = {
  tip: PropTypes.string,
  size: PropTypes.oneOf(['small', 'middle', 'large']),
  children: PropTypes.node,
};

export default LoadingSpinner;