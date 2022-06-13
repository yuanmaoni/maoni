
const isLeap = require('./isLeap');

test('ケース３：2022は閏年ではない。', () => {
  expect(isLeap(2022)).toBe(false);
});

test('ケース４：2023は閏年ではない。', () => {
  expect(isLeap(2023)).toBe(false);
});

test('ケース５：2024は閏年です。', () => {
  expect(isLeap(2024)).toBe(true);
});
