
const isLeap = require('./isLeap');

test('ケース１：2000は閏年です。', () => {
  expect(isLeap(2000)).toBe(true);
});

test('ケース２：2001は閏年ではない。', () => {
  expect(isLeap(2001)).toBe(false);
});
