const tryRequire = (path) => {
  try {
    const image = require(`${path}`);
    return image;
  } catch (err) {
    return false;
  }
};

// eslint-disable-next-line import/no-anonymous-default-export
export default {
  questionMark: require("./questionMark.png"),
  site_Image: tryRequire("./site_Image.png") || require("./questionMark.png"),
  site_Vector: tryRequire("./site_Vector.png") || require("./questionMark.png"),
  site_Vector_1:
    tryRequire("./site_Vector_1.png") || require("./questionMark.png"),
  site_Vector_2:
    tryRequire("./site_Vector_2.png") || require("./questionMark.png"),
  site_Line10: tryRequire("./site_Line10.png") || require("./questionMark.png"),
  site_Vector_3:
    tryRequire("./site_Vector_3.png") || require("./questionMark.png"),
  site_Vector_4:
    tryRequire("./site_Vector_4.png") || require("./questionMark.png"),
  site_Vector_5:
    tryRequire("./site_Vector_5.png") || require("./questionMark.png"),
};
