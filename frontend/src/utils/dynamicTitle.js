const VITE_APP_TITLE = '后台管理系统';

/**
 * 动态修改标题
 */
export function setTitle(title) {
  const text = title ? `${title} - ${VITE_APP_TITLE}` : VITE_APP_TITLE;
  document.title = text;
}
