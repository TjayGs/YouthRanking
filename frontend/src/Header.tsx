import { FC } from "react"
import { Pages } from "./constants"

interface HeaderComponentProps {
  setShowPage: (page: Pages) => void
}

export const HeaderComponent: FC<HeaderComponentProps> = (props: HeaderComponentProps) => {
    const { setShowPage } = props
    return (
        <nav className='navbar' role={'navigation'} aria-label='main navigation'>
        <div className='navbar-brand'>
          <a className="navbar-item" onClick={() => setShowPage(Pages.HOME)}> YouthIntake</a>

          {/* TODO for what ? */}
          <a role="button" className="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
          </a>
        </div>
        <div id="navbar-main" className="navbar-menu">
          <div className="navbar-start">
            <a className="navbar-item" onClick={() => setShowPage(Pages.CREATE_PLAYER)}>
              Erstelle Spieler
            </a>

            <a className="navbar-item" onClick={() => setShowPage(Pages.CREATE_SINGLE_GAME)}>
              Erstelle Einzel
            </a>

            <a className='navbar-item' onClick={() => setShowPage(Pages.CREATE_DOUBLE_GAME)}>
              Erstelle Doppel
            </a>

            <a className='navbar-item' onClick={() => setShowPage(Pages.HELP_FAQ)}>
              Hilfe
            </a>
          </div>
        </div>
        <div className="navbar-end">
        </div>
      </nav >
    )
}