import { render, screen } from "@testing-library/react";
import App from "./App";

test("renders monitoring dashboard title", () => {
  render(<App />);
  expect(screen.getByText(/Monitoring Dashboard/i)).toBeInTheDocument();
});
